package com.ruoyi;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class PolygonUtil {
    /**
     * 判断点是否在多边形内
     *
     * @param point 测试点
     * @param pts   多边形的点
     * @return
     * @return boolean
     * @throws
     * @Title: IsPointInPoly
     * @Description: TODO()
     */
    public static boolean isInPolygon(Point2D.Double point, List<Point2D.Double> pts) {
        int N = pts.size();
        boolean boundOrVertex = true;
        int intersectCount = 0;//交叉点数量
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point2D.Double p1, p2;//临近顶点
        Point2D.Double p = point; //当前点

        p1 = pts.get(0);
        for (int i = 1; i <= N; ++i) {
            if (p.equals(p1)) {
                return boundOrVertex;
            }

            p2 = pts.get(i % N);
            if (p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)) {
                p1 = p2;
                continue;
            }

            //射线穿过算法
            if (p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)) {
                if (p.y <= Math.max(p1.y, p2.y)) {
                    if (p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)) {
                        return boundOrVertex;
                    }

                    if (p1.y == p2.y) {
                        if (p1.y == p.y) {
                            return boundOrVertex;
                        } else {
                            ++intersectCount;
                        }
                    } else {
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if (Math.abs(p.y - xinters) < precision) {
                            return boundOrVertex;
                        }

                        if (p.y < xinters) {
                            ++intersectCount;
                        }
                    }
                }
            } else {
                if (p.x == p2.x && p.y <= p2.y) {
                    Point2D.Double p3 = pts.get((i + 1) % N);
                    if (p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)) {
                        ++intersectCount;
                    } else {
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }
        if (intersectCount % 2 == 0) {//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }
    }

    public static void main(String[] args) {
        Point2D.Double point = new Point2D.Double();
        point.setLocation(116.990589, 36.671499);

        List<Point2D.Double> pts = new ArrayList<>();
        Point2D.Double point1 = new Point2D.Double();
        point1.setLocation(116.990603, 36.671505);
        Point2D.Double point2 = new Point2D.Double();
        point2.setLocation(116.989603, 36.671505);
        Point2D.Double point3 = new Point2D.Double();
        point3.setLocation(116.989603, 36.670505);
        Point2D.Double point4 = new Point2D.Double();
        point4.setLocation(116.990603, 36.670505);
        pts.add(point1);
        pts.add(point2);
        pts.add(point3);
        pts.add(point4);
        boolean inPolygon = isInPolygon(point, pts);
        System.out.println(inPolygon);


//        boolean inPolygon1=isInCircle(113,36.671679,116.989321,
//                36.67149,
//                116.99058);
//        System.out.printf("inPolygon1---"+inPolygon1);

    }
    /**
     * 2     * 计算是否在圆上（单位/千米）
     * 3     *
     * 4     * @Title: GetDistance
     * 5     * @Description: TODO()
     * 6     * @param radius 半径
     * 7     * @param lat1  纬度
     * 8     * @param lng1  经度
     * 9     * @return
     * 10     * @return double
     * 11     * @throws
     * 12
     */
    /**
     * 地球半径
     */
    private static double EARTH_RADIUS = 6378138.0;

    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static boolean isInCircle(double radius, double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        if (s > radius) {//不在圆上
            return false;
        } else {
            return true;
        }
    }

}