class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        var angles = new ArrayList<Double>(points.size());
        var selfPoints = 0;

        for (var point : points) {
            if (point.get(0).equals(location.get(0)) && point.get(1).equals(location.get(1))) {
                ++selfPoints;
                continue;
            }
            
            angles.add(getAngle(location, point));
        }
        
        if (angle == 0) {
            var map = new HashMap<Double, Integer>();
            var max = 0;
            for (var a : angles) {
                var cnt = map.getOrDefault(a, 0);
                max = Math.max(max, cnt + 1);
                map.put(a, cnt + 1);
            }

            return max + selfPoints;
        }

        Collections.sort(angles);

        var cnt = 0;

        for (var a : angles) {
            var lo = a;
            var hi = a + angle;

            var cntTmp = 0;

            if (lo < 0) {
                var loTmp = 360 + lo;
                var hiTmp = 360;
                cntTmp += getCount(angles, loTmp, hiTmp);
                lo = 0.0;
            }

            if (hi >= 360) {
                var loTmp = 0;
                var hiTmp = hi - 360;
                cntTmp += getCount(angles, loTmp, hiTmp);
                hi = 360;
            }

            cntTmp += getCount(angles, lo, hi);

            cnt = Math.max(cnt, cntTmp);
        }

        return cnt + selfPoints;
    }

    private static double getAngle(List<Integer> point0, List<Integer> point1) {
        int x0 = point0.get(0), y0 = point0.get(1);
        int x1 = point1.get(0), y1 = point1.get(1);

        if (x0 == x1) {
            return y1 > y0 ? 90.0 : 270.0;
        }
        else if (y0 == y1) {
            return x1 > x0 ? 0.0 : 180.0;
        }
        else {
            var k = (double)(y1 - y0) / (x1 - x0);
            var angle = Math.toDegrees(Math.atan(k));

            if (x1 > x0 && y1 > y0) {
                return angle;
            }

            if (x1 < x0) {
                return 180.0 + angle;
            }

            return 360.0 + angle;
        }
    }

    private static int getCount(ArrayList<Double> angles, double lo, double hi) {
        var idxLo = Collections.binarySearch(angles, lo);
        var idxLoFound = true;
        if (idxLo < 0) {
            idxLo = -1 * (idxLo + 1);
            idxLoFound = false;
        }

        while (idxLo - 1 >= 0 && angles.get(idxLo - 1) == lo) {
            --idxLo;
        }

        var idxHi = Collections.binarySearch(angles, hi);
        var idxHiFound = true;
        if (idxHi < 0) {
            idxHi = -1 * (idxHi + 1);
            idxHiFound = false;
        }

        while (idxHi + 1 < angles.size() && angles.get(idxHi + 1) == hi) {
            ++idxHi;
        }

        return idxHi - idxLo + (idxLoFound && idxHiFound ? 1 : 0);
    }
}