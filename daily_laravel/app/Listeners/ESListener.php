<?php


namespace App\Listeners;


use App\Models\Industry;

class ESListener
{
    /**
     * Create the event listener.
     *
     * @return void
     */
    public function __construct()
    {
        //
    }

    /**
     * 为订阅者注册监听器。
     */
    public function subscribe($events)
    {
        $events->listen(
            \App\Events\ESIndustryEvent::class,
            'App\Listeners\ESListener@updateIndustry'
        );
    }

    /**
     * @throws \Exception
     */
    public function updateIndustry($event)
    {
        $industries = Industry::all();

        try {
            foreach ($industries as $industry) {
                $params = [
                    'index' => 'industry',
                    'id' => $industry->id,
                    'body' => [
                        'code' => $industry->industry_id,
                        'name' => $industry->name,
                        'desc' => $industry->description
                    ]
                ];

                $response = app('es')->create($params);
            }

        }catch (\Exception $e){
            throw new \Exception($e->getMessage());
        }
    }
}
