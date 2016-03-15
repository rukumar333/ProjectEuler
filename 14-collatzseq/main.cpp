#include <iostream>
#include <string>
#include <vector>

int runSeq(long currentNum, int count, std::vector<long> & listNumbers);
int length = 5000000;
int maxes[5000001];
int numbers[5000001];

int main(){
    int numCases = 0;
    std::string temp = "";
    std::getline(std::cin, temp);
    numCases = std::stoi(temp);
    std::vector<long> vectorNums;
    for(unsigned int i = 0; i <= length; ++ i){
	numbers[i] = 0;
	maxes[i] = 0;
    }
    int maxBase = 0;
    int maxCount = 0;
    int starting = 0;
    int count = 0;
    for(unsigned int i = 1; i <= length; ++ i){
	vectorNums = std::vector<long>();
	count = runSeq((long)i, 0, vectorNums);
	if(maxCount <= count){
	    maxCount = count;
	    maxBase = i;
	}	
	maxes[i] = maxBase;
	bool recurse = true;
	for(int j = 0; j < vectorNums.size() && recurse; ++ j){
	    if(vectorNums[j] <= length){
		if(numbers[vectorNums[j]] != 0){
		    recurse = false;
		}else{
		    numbers[vectorNums[j]] = count;
		}
	    }
	    -- count;
	}
    }
    int inputs[numCases];
    for(unsigned int i = 0; i < numCases; ++ i){
	std::getline(std::cin, temp);
	starting = std::stoi(temp);
	inputs[i] = starting;
	std::cout << maxes[starting] << std::endl;
    }
    return 1;
}

int runSeq(long currentNum, int count, std::vector<long> & listNumbers){
    if(currentNum <= length){
    	if(numbers[currentNum] != 0){
    	    return count + numbers[currentNum];
    	}	
    }
    ++ count;
    listNumbers.push_back(currentNum);
    if(currentNum == 1){
	return count;
    }
    if(currentNum % 2 == 0){
	currentNum = currentNum / 2;
	return runSeq(currentNum, count, listNumbers);
    }else{
	currentNum = (3 * currentNum) + 1;
	return runSeq(currentNum, count, listNumbers);
    }
}
