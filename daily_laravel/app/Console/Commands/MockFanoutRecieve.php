<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class MockFanoutRecieve extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:fanout-recieve';

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
        
        $channel->exchange_declare('logs', 'fanout', false, false, false);
        
        list($queue_name, ,) = $channel->queue_declare("", false, false, true, false);
        
        $channel->queue_bind($queue_name, 'logs');
        
        echo ' [*] Waiting for logs. To exit press CTRL+C', "\n";
        
        $callback = function($msg){
            echo ' [x] ', $msg->body, "\n";
        };
        
        $channel->basic_consume($queue_name, '', false, true, false, false, $callback);
        
        while(count($channel->callbacks)) {
            $channel->wait();
        }
        
        $channel->close();
        $connection->close();
    }
}
