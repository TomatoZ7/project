<?php


namespace App\Http\Controllers\Test;

use App\Events\ESIndustryEvent;
use Elasticsearch\ClientBuilder;

class ESApiTestController
{
    /**
     * 创建文档
     */
    public function createIndexDoc()
    {
        $params = [
            'index' => 'my_index',
            'id'    => 'my_id_1',
            'body'  => [
                'test_field' => 'def'
            ]
        ];

        $response = app('es')->index($params);
        dd($response);
    }

    /**
     * 获取文档信息
     */
    public function getIndexDocumentById($id)
    {
        $params = [
            'index' => 'my_index',
            'id'    => $id
        ];

        $response = app('es')->getSource($params);
        dd($response);
    }

    /**
     * 搜索文档
     */
    public function getIndexDocument()
    {
        $params = [
            'index' => 'my_index',
            'body' => [
                'query' => [
                    'match' => [
                        'test_field' => 'abc'
                    ]
                ]
            ]
        ];

        $response = app('es')->search($params);
        dd($response);
    }

    /**
     * 删除文档
     *
     * @param $id
     */
    public function delete($id)
    {
        $params = [
            'index' => 'my_index',
            'id'    => $id
        ];

        $response = app('es')->delete($params);
        dd($response);
    }

    /**
     * 删除索引
     *
     * @param $index_name
     */
    public function deleteIndex($index_name)
    {
        $params = [
            'index' => $index_name
        ];

        $response = app('es')->indices()->delete($params);
        dd($response);
    }

    /**
     * 创建索引
     */
    public function createIndex()
    {
        $params = [
            'index' => 'my_index',
            'body' => [
                'settings' => [
                    'number_of_shards' => 2,
                    'number_of_replicas' => 0
                ]
            ]
        ];

        $response = app('es')->indices()->create($params);
        dd($response);
    }

    /**
     * 将 Industry 表中数据迁移至 ES
     */
    public function genIndustryIndex()
    {
        event(new ESIndustryEvent());
    }

    /**
     * 搜索 industry
     */
    public function getIndustry($keyword)
    {
        $params = [
            'index' => 'industry',
            'body' => [
//                'from' => 0,
//                'size' => 20,
                'query' => [
                    'match' => [
                        'name' => $keyword
                    ],
                ],
                'highlight' => [
                    'fields' => [
                        'name' => [
                            'pre_tags' => "<span style='color:red;'>",
                            'post_tags' => "</span>"
                        ]
                    ]
                ]
            ]
        ];

        $response = app('es')->search($params);
        dd($response);
    }
}
