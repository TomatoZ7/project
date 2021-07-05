<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class MockWorkQueueRecieveSlowly extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:workqueue-recieve-slowly';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Command description';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     *
     * @return int
     */
    public function handle()
    {
        $connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');
        $channel = $connection->channel();
        
        $channel->queue_declare('task_queue', false, true, false, false);
        
        echo ' [*] Waiting for messages. To exit press CTRL+C', "\n";
        
        $callback = function($msg){
            echo " [x] Received ", $msg->body, "\n";
            sleep(substr_count($msg->body, '.'));
            echo " [x] Done", "\n";
            $msg->delivery_info['channel']->basic_ack($msg->delivery_info['delivery_tag']);
        };
        
        /**
         * 我们可以使用 basic_qos 方法和 prefetch_count = 1 设置。
         * 这告诉 RabbitMQ 一次不要向工作人员发送多个消息。
         * 或者换句话说，不要向工作人员发送新消息，直到它处理并确认了前一个消息。
         * 相反，它会将其分派给不是仍然忙碌的下一个工作人员。
         */
        $channel->basic_qos(null, 1, null);
        // 通过将第四个参数设置为 basic_consume 为 false（true 表示不询问），并在完成任务后向工作人员发送适当的确认
        $channel->basic_consume('task_queue', '', false, false, false, false, $callback);
        
        while(count($channel->callbacks)) {
            $channel->wait();
        }
        
        $channel->close();
        $connection->close();
    }
}
