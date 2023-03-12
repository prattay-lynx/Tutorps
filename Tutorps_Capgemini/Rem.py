# #Problem:
# You're given a two-dimensional array(a matrix)of potentially unequal height and width containing only 0 s and 1 s.The matrix represents a two-toned image, where each 1 represents black and each 0 represents white.An island is defined as any number of 1 s that are
# horizontally or vertically adjacent(but not diagonally adjacent) and that don'ttouch the border of the image.In other words,a group of horizontally or vertically adjacent 1 s isn'tan island if any of those 1 s are in the first row, last row, first column, or last column of the input matrix.
# Note that an island can twist.In other words, it doesn'thave to be a straight vertical line or a straight horizontal line
# it can be L-shaped, for example.
# You can think of islands as patches of black that don'ttouch the border of the two-toned image.
# Write a function that returns a modified version of the input matrix, where all of the islands are removed.You remove an island by replacing it with 0 s.
# Naturally, you're allowed to mutate the input matrix.


# Sample input matrix = [[1, 0, 0, 0, 0, 0],
#                        [0, 1, 0, 1, 1, 1],
#                        [0, 0, 1, 0, 1, 0],
#                        [1, 1, 0, 0, 1, 0],
#                        [1, 0, 1, 1, 0, 0],
#                        [1, 0, 0, 0, 0, 1]]

# Sample output matrix = [[1, 0, 0, 0, 0, 0],
#                         [0, 0, 0, 1, 1, 1],
#                         [0, 0, 0, 0, 1, 0],
#                         [1, 1, 0, 0, 1, 0],
#                         [1, 0, 0, 0, 0, 0],
#                         [1, 0, 0, 0, 0, 1]]
# // The islands that were removed can be clearly seen here:
# // [
#     // [, , , , , ],
#     // [, 1, , , , ],
#     // [, , 1, , , ],
#     // [, , , , , ],
#     // [, , 1, 1, , ],
#     // [, , , , , ],
#     //]
# #


def find_edges(island, m, n):
    output = []
    for i in range(m):
        for j in range(n):
            if (i == 0 or i == m-1 or j == 0 or j == n-1):
                if (island[i][j] == 1):
                    output.append((i, j))
    return output


all_visited = []


def find_neighbours(e):
    for edge_coord in e:
        st = [edge_coord]  # depth first serach
        visited = {edge_coord: []}

        while st:
            current = st.pop()
            current_row, current_col = current[0], current[-1]
            neighbors = []

            if current_row > 0:
                if island[current_row - 1][current_col] == 1:
                    neighbors.append((current_row-1, current_col))
            if current_row < len(island)-1:
                if island[current_row + 1][current_col] == 1:
                    neighbors.append((current_row+1, current_col))
            if current_col > 0:
                if island[current_row][current_col-1] == 1:
                    neighbors.append((current_row, current_col-1))
            if current_col < len(island[0])-1:
                if island[current_row][current_col+1] == 1:
                    neighbors.append((current_row, current_col+1))

            for neigbour in neighbors:
                if neigbour not in visited:
                    visited.setdefault(neigbour, [])
                    visited[neigbour].append(current)
                    st.append(neigbour)
        all_visited.append((visited))
    # for item in all_visited:
    #     print(item)
    return all_visited


def prep_coords(f):
    o = set()
    for dict_item in f:
        for key, value in dict_item.items():
            o.add(key)
            if value:
                o.add(value[0])
    return o


def filter_out_islands(c):
    out = []
    for i in range(len(island)):
        for j in range(len(island[0])):
            if island[i][j] == 1:
                if (i, j) not in c:
                    out.append((i, j))
    return out


island = [[1, 0, 0, 0, 0, 0],
          [0, 1, 0, 1, 1, 1],
          [0, 0, 1, 0, 1, 0],
          [1, 1, 0, 0, 1, 0],
          [1, 0, 1, 1, 0, 0],
          [1, 0, 0, 0, 0, 1]]

edge_coords = find_edges(island, 6, 6)
found_neighbours = find_neighbours(edge_coords)
connections = prep_coords(found_neighbours)
out = filter_out_islands(connections)

for r, c in out:
    island[r][c] = 0

for i in range(6):
    for j in range(6):
        print(island[i][j], end=" ")
    print("\n")
