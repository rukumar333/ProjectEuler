#include <iostream>
#include <string>
#include <vector>

int getTriangular(int ith);
int getNumDivisors(int num);
int getFirstTriangular(int numDivisors);
int fillPos = 1;
int gDivisors[1001];
int length = 1001;


int main(int argc, char *argv[]){
    std::string temp = "";
    int testCases = 0;
    std::getline(std::cin, temp);
    testCases = std::stoi(temp);
    int cases[testCases];
    for(unsigned int i = 0; i < length; ++ i)
	gDivisors[i] = 0;
    gDivisors[1] = 2;
    for(unsigned int i = 0; i < testCases; ++ i){
	std::getline(std::cin, temp);
	cases[i] = std::stoi(temp);
	std::cout << getFirstTriangular(cases[i]) << std::endl;	
    }
    return 1;
}

int getTriangular(int ith){
    if(ith == 1) return 1;
    if(ith % 2 == 0) 
	return (ith - (ith / 2)) * (ith + 1);
    else
	return ith + getTriangular(ith - 1);
}

int getFirstTriangular(int numDivisors){
    if(gDivisors[numDivisors] != 0)
	return getTriangular(gDivisors[numDivisors]);
    else{
	while(fillPos <= numDivisors){
	    ++ fillPos;
	    int startIth = gDivisors[fillPos - 1] + 1; 
	    int triangular = getTriangular(startIth);
	    int numTriDivisors = getNumDivisors(triangular);
	    while(numTriDivisors <= fillPos){
		++ startIth;
		triangular = getTriangular(startIth);
		numTriDivisors = getNumDivisors(triangular);
	    }
	    while(numTriDivisors > fillPos){
		gDivisors[fillPos] = startIth;
		++ fillPos;
	    }
	    -- fillPos;
	}
	return getTriangular(gDivisors[numDivisors]);
    }	
}

int getNumDivisors(int num){
    bool isEven = num % 2 == 0;
    int divisor = 1;
    int count = 0;
    while(divisor * divisor < num){
	if(num % divisor == 0) ++ count;
	if(!isEven) divisor = divisor + 2;
	else ++ divisor;
    }
    count = count * 2;
    if(divisor * divisor == num)
	++ count;
    return count;
}
