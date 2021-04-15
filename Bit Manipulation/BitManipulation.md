# Bit Manipulation
## basic operation
1. NOT
- ~0 = 1
- ~1 = 0
2. AND
- 1 & 1 = 1
- 0 & 0 = 0
- 1 & 0 = 0

3. OR
- 0 | 0 = 0
- 0 | 1 = 1
- 1 | 1 = 1


4. XOR
- 0 ^ 0 = 0
- 1 ^ 1 = 0
- 1 ^ 0 = 1

5. SHIFT
- 左移       
低位填0

0001 << 3 = 1000

- 右移    
  - arithmetic（常用，为了保证正负一致）   
    高位填之前的最高位      
    1100 >> 1 = 1110 
  - logical     
    高位填0       
    1100 >>> 1 = 0110 

## use case
### Even & Odd
- n & 1 == 1 ? Odd : Even
### Double
- a / 2 = a >> 1;
- a * (2^m) = a << m;      
注意不要超出位数
### Negative number
- a  = 101101100
- -a = 010010011 + 1 = 010010100
- Bit NOT on every bit and then plus 1.（补码取反+1）

### Specific bit operation
- Get kth bit:     (a >> k) & 1
- Set kth bit 0:  a = a & ~(1 << k)
- Set kth bit 1:  a = a | (1 << k)
- Rightmost 1-bit: a & -a
### Absolute value ***
|a| = a ^ (a >> 31) - (a >> 31)
### XOR
满足交换律和结合律
- a ^ a = 0
- a ^ 0 = a
- a ^ -1 = ~a  (-1二进制是1补码+1，全是1)
### Swap (int a, int b)
- a ^= b;
- b ^= a;  // b = b ^ (a' ^ b) = a'
- a ^= b;  // a = (a' ^ b') ^ a' = b'