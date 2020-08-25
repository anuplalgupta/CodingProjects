file1 = open('C:/Users/u6078131/Code/gitHub/CodingProjects/python-projects/columns_txn_ext.txt', 'r') 
Lines = file1.readlines() 
file2 = open('myfile.txt', 'w')   
count = 0
# Strips the newline character 
for line in Lines: 
    #print(line.strip())
    words = line.split(" as ");
    file2.write("aMap.put({},\"{}\");\n".format(words[1].split(',')[0].strip(), words[0].strip()))
    # print("put(\"{}\", {});".format(words[0].strip(), words[1].split(',')[0].strip())) 
file2.close()
file1.close()