package queue.code.catdogqueue;


import queue.code.catdogqueue.exist.Pet;

/**
 *       猫狗队列(❤)
 *
 * 题目：
 *  宠物、狗和猫的类 在 queue.code.catdogqueue.exist 包下；
 *
 *  实现一种猫狗队列的结构，要求如下：
 *  *add方法将cat或者dog实例放入队列
 *  *pollAll方法，将队列所有的实例按照进入队列顺序先后弹出
 *  *pollDog方法，将队列中dog类的实例按照进队列顺序先后弹出
 *  *pollCat方法，将队列中cat类的实例按照进队列顺序先后弹出
 *  *isEmpty方法，检查队列中是否还有dog或者cat的实例
 *  *isDogEmpty方法，检查队列中是否还有dog的实例
 *  *isCatEmpty方法，检查队列中是否还有cat的实例
 *
 *
 */


public class PetEnterQueue {

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet,long count){
        this.pet=pet;
        this.count=count;
    }

    public Pet getPet(){
        return  this.pet;
    }

    public long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }

}
