<?php

namespace App\Console\Commands;

use Illuminate\Console\Command;
use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;
use PhpAmqpLib\Wire\AMQPTable;


class MockTtlDirectSend extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'mock:ttl-direct';

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

        $args = new AMQPTable();
        $args->set('x-message-ttl', 30000);
        $channel->queue_declare('ttl_queue', false, true, false, false, false, $args);

        $data = "Hello ttl";
        $msg = new AMQPMessage($data);

        $channel->basic_publish($msg, '', 'ttl_queue');

        echo " [x] Send ttl message \n";

        $channel->close();
        $connection->close();
    }
}
