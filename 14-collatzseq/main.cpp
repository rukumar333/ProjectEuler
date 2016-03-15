#include <iostream>
#include <string>
#include <vector>

int runSeq(long currentNum, int count, std::vector<long> & listNumbers);
int length = 5000000;
int numbers[5000001];

int main(){
    int numCases = 0;
    std::string temp = "";
    std::getline(std::cin, temp);
    numCases = std::stoi(temp);
    int starting = 0;
    int count = 0;
    std::vector<long> vectorNums;
    // int inputs[numCases];
    // int maxCount = 0;
    // int maxBase = 0;    
    for(unsigned int i = 0; i <= length; ++ i){
	numbers[i] = 0;
    }
    for(unsigned int i = length; i >= 1; -- i){
	vectorNums = std::vector<long>();
	count = runSeq((long)i, 0, vectorNums);
	numbers[i] = count;
	for(int j = 0; j < vectorNums.size(); ++ j){
	    if(vectorNums[j] <= length){
		numbers[vectorNums[j]] = count;
	    }
	    -- count;
	}
    }
    for(unsigned int i = 0; i < numCases; ++ i){
	std::getline(std::cin, temp);
	starting = std::stoi(temp);
	vectorNums = std::vector<long>();
	count = runSeq((long)starting, 0, vectorNums);
	numbers[starting] = count;
	for(int j = 0; j < vectorNums.size(); ++ j){
	    if(vectorNums[j] <= length){
		numbers[vectorNums[j]] = count;
	    }
	    -- count;
	}

	// std::getline(std::cin, temp);
	// starting = std::stoi(temp);
	// int max = 0;
	// int maxNum = 0;
	// for(int k = starting; k >= 1; -- k){
	//     if(max < numbers[k]){
	// 	max = numbers[k];
	// 	maxNum = k;
	//     }
	// }
	// std::cout << maxNum << std::endl;
    }
    // for(unsigned int i = 0; i < numCases; ++ i){
    // 	starting = inputs[i];
    // 	int max = 0;
    // 	int maxNum = 0;
    // 	for(int k = starting; k >= 1; -- k){
    // 	    if(max < numbers[k]){
    // 		max = numbers[k];
    // 		maxNum = k;
    // 	    }
    // 	}
    // 	std::cout << maxNum << std::endl;
    // }
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
	// std::cout << "Is odd" << std::endl;
	currentNum = (3 * currentNum) + 1;
	return runSeq(currentNum, count, listNumbers);	
    }
}
