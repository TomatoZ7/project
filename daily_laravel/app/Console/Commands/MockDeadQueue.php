<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class MockDeadQueue extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:dead-queue';

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
        
        $channel->exchange_declare('dead_direct_exchange', 'direct', false, false, false);
        $channel->queue_declare("dead_direct_queue", false, true, false, false);
        
        $channel->queue_bind('dead_direct_queue', 'dead_direct_exchange', 'dead');
        
        echo ' [*] Waiting for dead message. To exit press CTRL+C', "\n";
        
        $callback = function($msg){
            echo ' [x] ',$msg->delivery_info['routing_key'], ':', $msg->body, "\n";
        };
        
        $channel->basic_consume('dead_direct_queue', '', false, true, false, false, $callback);
        
        while(count($channel->callbacks)) {
            $channel->wait();
        }
        
        $channel->close();
        $connection->close();
    }
}
