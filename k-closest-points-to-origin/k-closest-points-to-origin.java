class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>((p1, p2) -> Double.compare(p1.distanceToOrigin, p2.distanceToOrigin));
        
        for(int[] p : points){
            pq.add(new Point(p[0], p[1], getDistance(p[0], p[1], 0, 0)));
        }
        
        int[][] rtn = new int[k][2];
        
        for(int i=0; i<rtn.length; i++){
            Point p = pq.poll();
            rtn[i] = new int[]{p.x, p.y};
        }
        
        return rtn;
        
    }
    
    public double getDistance(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
    
    class Point{
        int x;
        int y;
        double distanceToOrigin;
        public Point(int x, int y, double distanceToOrigin){
            this.x = x;
            this.y = y;
            this.distanceToOrigin = distanceToOrigin;
        }
    }
}