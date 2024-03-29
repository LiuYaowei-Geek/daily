#Algorithm
##基础知识
1. 异或运算(^)，也叫无进位相加，二进制运算中，相等为1，不等为0。可用于两个非0数字的交换。
2. 双指针，枚举数组中两个元素，一个元素递增，另一个元素递减可以使用双指针。时间复杂度会减少一个指数级
3. 比较器，重写compare方法，当o1-o2为负数时，返回递增顺序；当o1-o2为负数时，返回递减顺序
4. mater公式
   ```text
   T(N) = a*T(N/b) + O(N^d)
   log(b,a) > d : O(N*log(b,a))
   log(b,a) < d : O(N^d)
   log(b,a) = d : O(N^d * logN)
   ```
5. 


##排序
1. 选择排序 时间复杂度O(N^2)   空间复杂度O(1)    不具备稳定性
2. 冒泡排序 时间复杂度O(N^2)   空间复杂度O(1)    具备稳定性
3. 插入排序 时间复杂度O(N^2)   空间复杂度O(1)    具备稳定性
4. 归并排序 时间复杂度O(NlogN) 空间复杂度O(N)    具备稳定性
5. 快速排序 时间复杂度O(NlogN) 空间复杂度O(logN) 不具备稳定性
6. 堆排序   时间复杂度O(NlogN) 空间复杂度O(1)    不具备稳定性
7. 不考虑稳定行优先使用快排(历史经验最快)，考虑稳定性优先选择归并排序，链表最适合归并排序
8. Arrays.sort，时间复杂度O(nlogn)，空间复杂度O(logn)


##链表
1. 找链表中点使用快慢指针，快指针每次走2步，慢指针每次走1步，当快指针到末尾时，慢指针指向中点。eg:1234,mid=3; 12345,mid=3;
2. 找链表第一个环，使用快慢指针。快指针每次走2步，慢指针每次走1步，当快慢指针位置节点相等时，快指针回到链表头，然后快慢指针每次都走1步，第一个相等的节点即是环的位置

##数组
1. 使用字符数组记录字符串，可以减少对字符串的字符排序时间

##树
1. 二叉搜索树BST：左子树所有节点的值都小于根节点，右子树所有节点值都大于根节点；所有左右子树也都为二叉搜索树

##动态规划
1. 背包问题判定：给定一个target，target可以是数字也可以是字符串，再给定一个数组nums，nums中装的可能是数字，也可能是字符串，问：能否使用nums中的元素做各种排列组合得到target
2. 组合问题公式：dp[i] += dp[i-cur]
3. trueOrFalse问题：dp[i] = dp[i] or dp[i-cur]
4. 最大最小问题：dp[i] = min(dp[i], dp[i-cur]+1) 或者 dp[i] = max(dp[i], dp[i-cur]+1)
5. 0-1背包问题，数组中元素不能重复使用，nums放循环外，target在内循环。且内循环倒序。
   ```java
   for num in nums:
       for i in range(target, nums-1, -1):
   ```
6. 如果是完全背包，即数组中的元素可重复使用，nums放在外循环，target在内循环。且内循环正序。
   ```java
   for num in nums:
       for i in range(nums, target+1):
   ```
7. 如果组合问题需考虑元素之间的顺序，需将target放在外循环，将nums放在内循环。
   ```java
   for i in range(1, target+1):
       for num in nums:
   ```