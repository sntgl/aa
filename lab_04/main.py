from threading import Thread


class Matrix:
    mult = 0
    size = 0
    matrix = []

    def __init__(self, mult, size, matrix):
        self.mult = mult
        self.size = size
        self.matrix = matrix

    def __str__(self):
        return f'size = {self.size}, mul = {self.mult}, matrix = {self.matrix}'


mm = Matrix(1, 5, [[1, 2, 3, 4, 11], [5, 6, 6, 23, 11], [7, 8, 12, 54, 11], [44, 9, 9, 8, 11], [10, 11, 12, 13, 14]])
matrixes = [mm]


def calc():
    m = matrixes.pop(0)
    if m.size == 2:
        return (m.matrix[0][0] * m.matrix[1][1] - m.matrix[0][1] * m.matrix[1][0]) * m.mult
    for i in range(m.size):
        mul = m.matrix[0][i] * m.mult
        if i % 2 == 1:
            mul *= -1
        size = m.size - 1
        matrix = []
        for j in range(1, m.size):
            matrix.append([])
            for k in range(m.size):
                if k != i:
                    matrix[-1].append(m.matrix[j][k])
        matrixes.append(Matrix(mul, size, matrix))
    return 0


s = 0
while len(matrixes) != 0:
    s += calc()
print(s)
