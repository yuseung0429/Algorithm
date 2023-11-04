# link : https://school.programmers.co.kr/learn/courses/30/lessons/172928
# title : 공원 산책

def solution(park, routes):
    for r_idx, i in enumerate(park):
        for c_idx, j in enumerate(i):
            if(j == "S"):
                dog = Dog(park, c_idx, r_idx)
    for inst in routes :
        arg = inst.split(" ")
        if arg[0] == "E":
            dog.Right(int(arg[1]))
        elif arg[0] == "W":
            dog.Left(int(arg[1]))
        elif arg[0] == "N":
            dog.Up(int(arg[1]))
        else :
            dog.Down(int(arg[1]))
        print(dog.getPos())
    return dog.getPos()

class Dog :
    def __init__(self, park, xpos, ypos) :
        self.park = park
        self.xpos = xpos
        self.ypos = ypos
    def Right(self, step) :
        for i in range(self.xpos+1, self.xpos+step+1) :
            if (i >= len(self.park[0])) or (self.park[self.ypos][i] == "X") :
                return
        self.xpos += step
    def Left(self, step) :
        for i in range(self.xpos-1, self.xpos-step-1, -1) :
            if (i < 0) or (self.park[self.ypos][i] == "X") :
                return
        self.xpos -= step
    def Up(self, step) :
        for i in range(self.ypos-1, self.ypos-step-1, -1) :
            if (i < 0) or (self.park[i][self.xpos] == "X") :
                return
        self.ypos -= step
    def Down(self, step) :
        # x.pos : 2, y.pos:0 0+2+1
        for i in range(self.ypos+1, self.ypos+step+1) :
            if (i >= len(self.park)) or (self.park[i][self.xpos] == "X") :
                return
        self.ypos += step
    def getPos(self) :
        return [self.ypos, self.xpos]
    
park = ["SOO","OXX","OOO"]
routes = ["E 2","S 2","W 1"]
print(solution(park, routes))