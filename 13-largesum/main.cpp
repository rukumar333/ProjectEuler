#include <iostream>
#include <string>

int main(){
    // std::cout << (9 / 10) << std::endl;
    int num = 0;
    std::cin >> num;
    std::string numbers[num];
    std::string result = "";
    int carry = 0;
    int sum = 0;
    int multipleten = 0;
    std::string insert = "";
    for(int i = 0; i < num; i ++){
	std::cin >> numbers[i];
    }
    for(int i = 49; i > -1; i--){
	sum = 0;
    	for(int k = 0; k < num; k++){
	    sum = sum + (numbers[k][i] - '0');	    
    	}
	sum = sum + carry;
	carry = sum / 10;
	insert = std::to_string(sum % 10);
	result.insert(0, insert);
    }
    if(carry != 0){
	result.insert(0, std::to_string(carry));
    }
    for(int i = 0; i < 10; i ++){
	std::cout << result[i];
    }
    return 1;
}
