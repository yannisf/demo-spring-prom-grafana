package eu.frlab.metrics

import java.util.concurrent.ArrayBlockingQueue

class GreedyBlockingQueue<E>(maxSize: Int): ArrayBlockingQueue<E>(maxSize) {

    override fun add(element: E): Boolean {
        if (remainingCapacity() < 1) poll()
        return super.add(element)
    }

}
