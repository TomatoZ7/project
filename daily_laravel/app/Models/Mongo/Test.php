<?php

namespace App\Models\Mongo;

use Jenssegers\Mongodb\Eloquent\Model;

class Test extends Model
{
    // protected $connection = 'mongodb';
    protected $connection = 'mongodb_replica_set';

    // protected $collection = 'test';
    protected $collection = 'protected $collection';
}
