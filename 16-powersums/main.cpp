#include <iostream>
#include <string>

void PowTwoBigInt(int index);
int powerSums[10001];
int numHolder[3011];
int numBeginIndex = 3010;


int main(){
    int testCases = 0;
    std::string temp;
    std::getline(std::cin, temp);
    testCases = std::stoi(temp);
    int cases[testCases];
    numHolder[numBeginIndex] = 1;
    for(int i = 1; i < 10001; ++ i){
	PowTwoBigInt(i);
    }
    for(unsigned int i = 0; i < testCases; ++ i){
    	std::getline(std::cin, temp);
    	cases[i] = std::stoi(temp);
	std::cout << powerSums[cases[i]] << std::endl;
    }
    return 1;
}

void PowTwoBigInt(int index){
    int carry = 0;
    int current = 0;
    int sum = 0;
    char lowerIndex = 0;
    for(int i = 3010; i >= numBeginIndex; -- i){
	current = numHolder[i];
        current = (current * 2) + carry;
	if(i == numBeginIndex){
	    carry = current / 10;
	    current = current % 10;
	    numHolder[i] = current;
	    if(carry != 0){
		sum = sum + carry;
		numHolder[i - 1] = carry;
		lowerIndex = 1;
	    }
	    sum = sum + current;
	}else{
	    carry = current / 10;
	    current = current % 10;
	    numHolder[i] = current;
	    sum = sum + current;
	}
    }
    if(lowerIndex)
	-- numBeginIndex;
    powerSums[index] = sum;
}
