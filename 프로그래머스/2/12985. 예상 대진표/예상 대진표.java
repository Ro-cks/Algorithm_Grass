class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            
            ++answer;
        }
        /*
        a = 4, 2, 1
        b = 7, 4, 2
        */
        return answer;
    }
}