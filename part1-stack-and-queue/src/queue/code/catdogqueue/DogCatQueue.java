package queue.code.catdogqueue;

import queue.code.catdogqueue.exist.Cat;
import queue.code.catdogqueue.exist.Dog;
import queue.code.catdogqueue.exist.Pet;

import java.util.LinkedList;
import java.util.Queue;

public class DogCatQueue {
    //存放dog实例的queue
    private Queue<PetEnterQueue> dogQ;
    //存放cat实例的queue
    private Queue<PetEnterQueue> catQ;
    //计数--保存存放顺序
    private long count;

    public DogCatQueue() {
        dogQ = new LinkedList<>();
        catQ = new LinkedList<>();
        count = 0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            dogQ.add(new PetEnterQueue(pet,count++));
        }else if(pet.getPetType().equals("cat")){
            catQ.add(new PetEnterQueue(pet,count++));
        }else{
            throw new RuntimeException("not dog or cat");
        }
    }

    public Pet pollAll(){
        if(!dogQ.isEmpty()&&!catQ.isEmpty()){
            if(dogQ.peek().getCount()<catQ.peek().getCount()){
                return dogQ.poll().getPet();
            }else{
                return catQ.poll().getPet();
            }
        }else if(!dogQ.isEmpty()){
            return dogQ.poll().getPet();
        }else if(!catQ.isEmpty()){
            return catQ.poll().getPet();
        }else{
            throw new RuntimeException("queue is empty");
        }
    }

    public Dog pollDog(){
        if(!dogQ.isEmpty()){
            return (Dog) dogQ.poll().getPet();
        }else{
            throw new RuntimeException("dogqueue is empty");
        }
    }

    public Cat pollCat(){
        if(!catQ.isEmpty()){
            return (Cat) catQ.poll().getPet();
        }else{
            throw new RuntimeException("dogqueue is empty");
        }
    }

    public boolean isEmpty(){
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public  boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }
}
