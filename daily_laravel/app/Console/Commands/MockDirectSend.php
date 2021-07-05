<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class MockDirectSend extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:direct-send';

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
        
        $channel->exchange_declare('direct_logs', 'direct', false, false, false);
        
        $data = "Hello Direct!";
        $msg = new AMQPMessage($data);
        
        $severity = "info";
        
        $channel->basic_publish($msg, 'direct_logs', $severity);
        
        echo " [x] Sent ",$severity,':',$data," \n";

        $channel->close();
        $connection->close();
    }
}
