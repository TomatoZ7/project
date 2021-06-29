<?php

namespace Database\Factories;

use App\Models\Post;
use Illuminate\Database\Eloquent\Factories\Factory;

class PostFactory extends Factory
{
    /**
     * The name of the factory's corresponding model.
     *
     * @var string
     */
    protected $model = Post::class;

    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {
        return [
            // 返回一个句子
            'title' => trim($this->faker->sentence, '.'),
            // 返回3个段落。false表示返回一个数组，true表示将段落拼接在一起，并且用换行符分割
            'content' => $this->faker->paragraphs(3, true),
        ];
    }
}
