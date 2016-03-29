#include <iostream>
#include <string>

int getMaxLength(int * numbers, int * distances, int firstDim, int secondDim, int & numRows);

int main(){
    int testCases = 0;
    std::string temp = "";
    int rows = 0;
    std::getline(std::cin, temp);
    testCases = std::stoi(temp);    
    for(int i = 0; i < testCases; ++ i){
	std::getline(std::cin, temp);
	rows = std::stoi(temp);
	int numbers[rows * rows];
	int distances[rows * rows];
	char index = 0;
	for(int k = 0; k < rows; ++ k){
	    std::getline(std::cin, temp);
	    std::string num = "";
	    index = 0;
	    for(int j = 0; j < temp.length(); ++ j){
		if(temp[j] == ' '){
		    numbers[k + index * rows] = std::stoi(num);
		    distances[k + index * rows] = -1;
		    ++ index;
		    num = "";
		}else{
		    num = num + temp.substr(j, 1);
		}
		if(j == temp.length() - 1){
		    numbers[k + index * rows] = std::stoi(num);
		    distances[k + index * rows] = -1;
		    ++ index;
		    num = "";
		}
	    }
	}
	std::cout << getMaxLength(numbers, distances, 0, 0, rows) << std::endl;
    }
    return 1;
}

int getMaxLength(int * numbers, int * distances, int firstDim, int secondDim, int & numRows){
    if(firstDim == 0)
	*distances = *numbers;
    int thisDist = *(distances + firstDim + secondDim * numRows);
    if(firstDim == numRows - 1){
	return thisDist;
    }
    int * leftDis = (distances + firstDim + 1 + (secondDim * numRows));
    int * rightDis = (distances + firstDim + 1 + (secondDim * numRows + numRows));
    int * leftNum = (numbers + firstDim + 1 + (secondDim * numRows));
    int * rightNum = (numbers + firstDim + 1 + (secondDim * numRows + numRows));
    int totalLeft = -1;
    int totalRight = -1;
    if(*leftDis < thisDist + *leftNum){
	*leftDis = thisDist + *leftNum;
	totalLeft = getMaxLength(numbers, distances, firstDim + 1, secondDim, numRows);
    }
    if(*rightDis < thisDist + *rightNum){
	*rightDis = thisDist + *rightNum;
	totalRight = getMaxLength(numbers, distances, firstDim + 1, secondDim + 1, numRows);
    }
    if(totalRight > totalLeft)
	return totalRight;
    else
	return totalLeft;    
}
