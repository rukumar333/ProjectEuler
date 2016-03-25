#include <iostream>
#include <string>

long factorials[501];
int pos = 0;
long getNumRoutes(int x, int y);
long getFactorial(int num);

int main(){
    getFactorial(500);
    int testCases = 0;
    std::string temp = "";
    std::getline(std::cin, temp);
    testCases = std::stoi(temp);
    std::string cases[testCases];
    for(unsigned int i = 0; i < testCases; ++ i){
	std::getline(std::cin, temp);
	cases[i] = temp;
	int indexSpace = cases[i].find(" ");
	int x = std::stoi(cases[i].substr(0, indexSpace));
	int y = std::stoi(cases[i].substr(indexSpace + 1, cases[i].length()));
	int result = getNumRoutes(x, y);
	// std::cout << getNumRoutes(0, 0, x, y, grid) << std::endl;
	std::cout << result << std::endl;
    }
    return 1;
}

long getFactorial(int num){
    if(pos >= num) return factorials[num];
    else{
	while(pos <= num){
	    if(pos == 0){
		factorials[pos] = 1;
		// std::cout << "Pos is zero" << std::endl;
	    }
	    else {
		factorials[pos] = (factorials[pos - 1] % 1000000007) * (pos % 1000000007);
		factorials[pos] = factorials[pos] % 1000000007;
		// factorials[pos] = factorials[pos - 1] * pos;
		// std::cout << "Pos: " << pos << std::endl;
		// std::cout << "Prev" << factorials[pos - 1] << std::endl;
	    }
	    // std::cout << factorials[pos] << std::endl;
	    ++ pos;
	}
	return factorials[num];
    }
}

long getNumRoutes(int x, int y){
    return (getFactorial(x + y) / (getFactorial(x) * getFactorial(y))) % 1000000007;
}
