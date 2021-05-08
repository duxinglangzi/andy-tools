#!/bin/sh

price=$(expr $RANDOM % 10)
times=0

echo "请输入一个价格值，看看你猜的对不对?"
echo "先打印一下价格值，防止我猜不到  $price "
while true 
do 
 #对次数进行增加
 let times++
 read -p "请输入价格吧:" INT
 if [ $INT -eq $price ];then 
    echo "猜对了，厉害啊， $price"
    echo "你一共猜了 $times 次"
    exit 0
 elif [ $INT -gt $price ];then
    echo "猜的太高了"
 else
    echo "猜的太低了"
 fi
done 



