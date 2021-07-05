<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class MockWorkQueueSend extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:workqueue-send';

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
        
        /**
         * 需要确保 RabbitMQ 永远不会失去我们的队列。
         * 为了做到这一点，我们需要宣布它是持久的。
         * 为此，我们将第三个参数传递给 queue_declare 为 true ：
         */
        $channel->queue_declare('task_queue', false, true, false, false);
        
        for ($i = 0; $i < 40; $i++) {
            $data = "Hello WorkQueue {$i}";
            /**
             * 此时我们确信，即使 RabbitMQ 重新启动，task_queue 队列也不会丢失。
             * 现在我们需要将消息标记为持久消息 - 
             *      通过设置 AMQPMessage 作为属性数组的一部分所使用的 delivery_mode = 2 消息属性。
             */
            $msg = new AMQPMessage($data, array('delivery_mode' => AMQPMessage::DELIVERY_MODE_PERSISTENT));
            
            $channel->basic_publish($msg, '', 'task_queue');
        }
        
        
        echo " [x] Sent 40 messages\n";
        
        $channel->close();
        $connection->close();
    }
}
