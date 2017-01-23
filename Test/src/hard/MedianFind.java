package hard;

public class MedianFind {
/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * Example 1
 * nums1 = [1, 3], nums2 = [2]
 * The median is 2.0
 * Example 2
 * nums1 = [1, 2], nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * ����λ����ʱ�临�Ӷ�O(log(m+n))
 * 
 * */
	//TODO normal method:����һ�������ð������ȡ��λ��
	//����ǳ�ʱ������ܼ򵥣��Լ�д��
	//TODO medium method:�������˼·�Ƕ�������
	//���ȣ�������n����������ֻҪȡ��n/2(��Ϊk)��������ʵ�ǲ���Ҫ�����
	//��Ϊ�������������Ѿ�����������ˣ�ֻҪ�����Ƚϴ�С�ͺ�
	//������num1�еĵ�p+1����num2�еĵ�q+1��Ϊ��λ��������ߵ�ƽ��������λ��
	//nΪ����ʱ��Ҫ�ҵ���(n/2+1)������nΪż��ʱ��Ҫ�ҵ���n/2��n/2+1����
	//������Ҫ���ǵ��ǣ��������鳤�Ȳ���ȵ��������������
	//TODO hard method:���ַ�
	//���ȣ�num1���м�����a������num2���м����Ϊ��b����������Ҫȡ���ǵ�k����
	//���num1[a] < num2[b],��ô������Ϊ��k��������num1��ǰa-1������
	//����������ע�Ͳ��֣���cpp�Ĵ��룬��û����(.)
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        //begin
        if (len%2==0) {
            return (findm(nums1, nums2, len/2) + findm(nums1, nums2, len/2+1))/2.0;
        } else {
            return findm(nums1, nums2, len/2+1);
        }
    }
    public double findm(int[] nums1, int[] nums2, int size) {
        int p=0,q=0;
        for(int i=0;i < size-1;i++) {
            if (p>=nums1.length && q<nums2.length ) {
                q++;
            } else if (q>=nums2.length && p<nums1.length) {
                p++;
            } else if (nums1[p] > nums2[q]) {
                q++;
            } else {
                p++;
            }
        }
        if (p >= nums1.length) {
            return nums2[q];
        } else if (q >= nums2.length) {
            return nums1[p];
        } else {
            return Math.min(nums1[p], nums2[q]);
        }
    }
    

}
/*
double findKth(int a[], int m, int b[], int n, int k)  
{  
    //always assume that m is equal or smaller than n  
    if (m > n)  
        return findKth(b, n, a, m, k);  
    if (m == 0)  
        return b[k - 1];  
    if (k == 1)  
        return min(a[0], b[0]);  
    //divide k into two parts  
    int pa = min(k / 2, m), pb = k - pa;  
    if (a[pa - 1] < b[pb - 1])  
        return findKth(a + pa, m - pa, b, n, k - pa);  
    else if (a[pa - 1] > b[pb - 1])  
        return findKth(a, m, b + pb, n - pb, k - pb);  
    else  
        return a[pa - 1];  
}  
  
class Solution  
{  
public:  
    double findMedianSortedArrays(int A[], int m, int B[], int n)  
    {  
        int total = m + n;  
        if (total & 0x1)  
            return findKth(A, m, B, n, total / 2 + 1);  
        else  
            return (findKth(A, m, B, n, total / 2)  
                    + findKth(A, m, B, n, total / 2 + 1)) / 2;  
    }  
};  
*/