/**
 * Created by Samer on 24/12/2017.
 */
import java.util.*

data class Node(val parent: Int?, val node: Int, var childrenCount: Int)

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)

    val nodes = mutableListOf<Node>()
    val size = sc.nextInt()
    sc.nextInt()
    for (i in 1 until size) {
        val child = sc.nextInt()
        val parent = sc.nextInt()
        if (nodes.isEmpty()) {
            nodes.add(Node(null, parent, 0))
        }

        nodes.add(Node(parent, child, 0))
    }

    for (i in nodes.size - 1 downTo 0)
        getParentNode(nodes, nodes[i].parent)?.let { parent ->
            parent.childrenCount += nodes[i].childrenCount + 1
        }




    for (node in nodes) {
        println("Node is ${node.node} and has ${node.childrenCount} children")
    }
}


fun getParentNode(list: MutableList<Node>, parent: Int?) = list.find { parent == it.node }