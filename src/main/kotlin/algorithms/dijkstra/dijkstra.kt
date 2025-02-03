package org.example.algorithms.dijkstra

import java.util.PriorityQueue

data class Edge(val node: Int, val weight: Int)
data class State(val distance: Int, val node: Int) : Comparable<State> {
    override fun compareTo(other: State): Int {
        return this.distance - other.distance
    }
}

fun dijkstra(graph: Array<MutableList<Edge>>, start: Int): IntArray {
    val distances = IntArray(graph.size) { Int.MAX_VALUE }  // 모든 노드의 거리를 무한대로 초기화
    distances[start] = 0  // 시작 노드의 거리는 0으로 설정

    val priorityQueue = PriorityQueue<State>()  // 우선순위 큐 생성
    priorityQueue.add(State(0, start))  // (거리, 시작 노드) 추가

    while (priorityQueue.isNotEmpty()) {
        val (currentDistance, currentNode) = priorityQueue.poll()

        // 이미 더 짧은 경로를 알고 있다면 무시
        if (currentDistance > distances[currentNode]) continue

        // 인접 노드 탐색
        for (edge in graph[currentNode]) {
            val newDistance = currentDistance + edge.weight

            // 더 짧은 경로가 발견되면 업데이트 및 우선순위 큐에 추가
            if (newDistance < distances[edge.node]) {
                distances[edge.node] = newDistance
                priorityQueue.add(State(newDistance, edge.node))
            }
        }
    }

    return distances  // 모든 노드에 대한 최단 거리 반환
}

fun main() {
    val graph = Array(6) { mutableListOf<Edge>() }  // 노드 0~5인 그래프 예제

    // 그래프의 간선 정보 추가 (노드 간 연결 및 가중치)
    graph[0].add(Edge(1, 2))
    graph[0].add(Edge(2, 4))
    graph[1].add(Edge(2, 1))
    graph[1].add(Edge(3, 7))
    graph[2].add(Edge(4, 3))
    graph[3].add(Edge(5, 1))
    graph[4].add(Edge(3, 2))
    graph[4].add(Edge(5, 5))

    val startNode = 0
    val distances = dijkstra(graph, startNode)

    // 결과 출력
    distances.forEachIndexed { index, distance ->
        println("노드 $index : ${if (distance == Int.MAX_VALUE) "도달 불가" else distance}")
    }
}
