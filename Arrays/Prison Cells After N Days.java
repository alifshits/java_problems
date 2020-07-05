class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Integer state = ToState(cells);
        HashMap<Integer, Integer> stateToDay = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> dayToState = new HashMap<Integer, Integer>();
        int day = 0;

        stateToDay.put(state, 0);
        dayToState.put(0, state);
        ++day;

        while (day <= N) {

            Integer currentState = GetNextState(state);
            var dayTmp = stateToDay.getOrDefault(currentState, -1);
            if (dayTmp == -1) {
                stateToDay.put(currentState, day);
                dayToState.put(day, currentState);
                state = currentState;
                ++day;
            } else {
                int cycle = day - dayTmp;
                int remaining = N - day;
                state = dayToState.get(dayTmp + remaining % cycle);
                break;
            }
        }

        return FromState(state);
    }

    private static Integer ToState(int[] cells) {
        Integer res = 0;

        for (int i = cells.length - 1; i >= 0; --i) {
            if (cells[i] == 1)
                res |= 1 << (cells.length - 1 - i);
        }

        return res;
    }

    private static int[] FromState(Integer state) {
        int[] cells = new int[8];

        for (int i = cells.length - 1; i >= 0; --i) {
            if ((state & 1) == 1)
                cells[i] = 1;

            state >>= 1;
        }

        return cells;
    }

    private static Integer GetNextState(Integer state) {
        Integer res = 0;

        for (int i = 1; i <= 6; ++i) {
            int prev = (state >> (7 - i + 1) & 1);
            int next = (state >> (7 - i - 1) & 1);

            if ((prev ^ next) != 1)
                res |= 1 << (7 - i);
        }

        return res;
    }
}