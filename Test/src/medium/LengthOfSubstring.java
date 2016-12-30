package medium;

public class LengthOfSubstring {
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
*/
	//the longest string must between two same char
    static int[] last = new int[128];
    public int lengthOfLongestSubstring(String s) {
    //�����������ַ��ӿո񵽴�д��ĸZ������128�㹻��
        int start = 0;
        int len = 0;
        char[] w = new char[s.length()];
        w = s.toCharArray();
        for(int i = 0; i < 128; i++)
            last[i] = -1;//last�������ڱ����³��ֵ��ַ����±꣬һ��ʼȫ����ʼ��Ϊ-1
        for(int i = 0; i < s.length(); ++ i){
            if(last[w[i]-' '] >= start){ //��ǰ����ַ����ֹ�
                if(i-start > len)
                    len = i-start;
                start = last[w[i]-' '] + 1; //������ַ��ϴγ��ֵ�λ��+1����Ϊ��һ��Ҫ�㳤�ȵ�
            }
                last[w[i]-' '] = i;//���µ�ǰ�ַ����±�
        }
        if(len > s.length() - start)//��Խ�β���ַ�û����֮ǰ���ֹ�������β�������ǡ�������������Լ�ȫ��������ͬ�ַ��������
            return len;//����aab����ַ�����bbbbb����ַ���
        else
            return s.length() - start;//һ��Ҫ-start����Ϊ�п����ǡ�bbbbb������
    }
}
