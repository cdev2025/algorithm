package day06.gamemap_bfs;

import java.util.*;

public class Solution {

        class Location{
        int x, y;
        Location(int x, int y) { this.x=x; this.y=y; }
        
        // 현재 위치와 다른 위치가 같은지 비교하는 메서드
        public boolean equals(Location other){
            return this.x==other.x && this.y==other.y;
        }
        
        // 현재 위치를 기준으로 각 방향으로 한 칸 이동한 새로운 위치를 반환하는 메서드
        Location left() { return new Location(x-1, y); }
        Location right() { return new Location(x+1, y); }
        Location up() { return new Location(x, y-1); }
        Location down() { return new Location(x, y+1); }
    }
    
    class Position{
        int steps; // 시작점에서 현재 위치까지 이동한 걸음 수
        Location location; // 현재 탐색 중인 위치
        Position(Location l, int s) { location=l; steps=s; }
    }
    
    // 최단거리 문제: BFS => level별 탐색 (최단 거리 보장)
    public int solution(int[][] maps) {
        final int mapSizeX = maps.length; // 맵 가로 크기
        final int mapSizeY = maps[0].length; // 맵 세로 크기
        // 타겟 위치는 맵의 오른쪽 하단
        final Location target = new Location(mapSizeX-1, mapSizeY-1);
        
        boolean[][] visited = new boolean[mapSizeX][mapSizeY]; 
        
        // BFS = 대기열에 Queue 활용
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(new Location(0,0), 1)); // 시작위치 (0,0), 초기 걸음 수 1
        
        while(!queue.isEmpty()){
            Position now = queue.poll();//현재 위치를 큐에서 꺼냄
            
            // 맵의 범위를 벗어나면 다음 위치로 넘어가도록 check
            if(now.location.x<0) continue; // 왼쪽 밖
            if(now.location.x >= mapSizeX) continue; // 오른쪽 밖
            if(now.location.y < 0) continue; // 위쪽 밖
            if(now.location.y >= mapSizeY) continue; //  아래쪽 밖
            if(maps[now.location.x][now.location.y]==0) continue; // 벽
            if(visited[now.location.x][now.location.y]) continue; // 이미 방문한 위치인지
            
            // 목표 위치에 도달하면 걸음 수 반환
            if(now.location.equals(target)){
                return now.steps;
            }
            
            visited[now.location.x][now.location.y] = true; // 방문 체크
            
            // 다음 방문할 위치들을 큐에 추가
            queue.offer(new Position(now.location.left(), now.steps+1));
            queue.offer(new Position(now.location.right(), now.steps+1));
            queue.offer(new Position(now.location.up(), now.steps+1));
            queue.offer(new Position(now.location.down(), now.steps+1));
            
        }
        
        return -1; // 타켓에 도달할 수 없을 때 -1 리턴
    }

    // ✅ main 메서드 추가
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] map1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int[][] map2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println("결과1: " + s.solution(map1)); // 👉 기대값: 11
        System.out.println("결과2: " + s.solution(map2)); // 👉 기대값: -1
    }
}

