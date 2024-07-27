A1 = 3
A0 = 7
B1 = 8
B0 = 1
N = 2

C2 = A1 * B1
C0 = A0 * B0
C1 = ((A1 + A0) * (B1 + B0)) - (C2+ C0)

C = (C2 * (pow(10, N))) + (C1 * (pow(10, N/2))) + C0

print (C2, C1, C0, C)