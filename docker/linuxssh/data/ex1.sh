VARIABLE_NAME="Hello"

echo $VARIABLE_NAME
echo ${VARIABLE_NAME}

echo "첫번째 인자 : $1"
echo "두번째 인자 : $2"

echo -n "이름을 입력하세요: "
read USER_NAME
echo "안녕하세요, $USER_NAME 님"
