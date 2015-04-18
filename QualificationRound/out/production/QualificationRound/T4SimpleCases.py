count = 0
output = open("question_4_all_simle_case.txt",'w+')
for i in range(1,5):
    for j in range(1,5):
        for k in range(1,5):
            if (i*j)%k == 0:
                count +=1
                output.write(str(i)+" "+str(j)+" "+str(k)+"\n")
output.close()
