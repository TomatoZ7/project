<?php


namespace App\Http\Controllers\Test;

use PhpAmqpLib\Connection\AMQPStreamConnection;
use PhpAmqpLib\Message\AMQPMessage;

class RabbitMQController
{
    public function testSend()
    {
        $connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');
        $channel = $connection->channel();
        
        $channel->queue_declare('hello', false, false, false, false);
        
        $msg = new AMQPMessage('Hello World!');
        $channel->basic_publish($msg, '', 'hello');
        
        echo " [x] Sent 'Hello World!'\n";
        
        $channel->close();
        $connection->close();
    }
    
    public function testRecieve()
    {
        $connection = new AMQPStreamConnection('localhost', 5672, 'guest', 'guest');
        $channel = $connection->channel();
        
        $channel->queue_declare('hello', false, false, false, false);
        
        echo ' [*] Waiting for messages. To exit press CTRL+C', "\n";
        
        $channel->basic_consume('hello', '', false, true, false, false, function($msg) {
            dd($msg);
        });
        
        while(count($channel->callbacks)) {
        //   $channel->wait();
            dd('0.0');
        }
    }
}
