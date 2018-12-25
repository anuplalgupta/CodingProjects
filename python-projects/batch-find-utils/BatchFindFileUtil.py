import sys
import re
#import nltk
#nltk.download('punkt')
#An utility  program to search a file for list of keywords and report presence 
# with line number

# loop  loop

def main():
    if len(sys.argv) <  2:
        print("Usage: BatchFileFindUtil.py <file_absolute_path> <Keyword1> <Keyword2> ...")
        return

    filePath = sys.argv[1]
    #print("file path is" + filePath)

    f = open(filePath,"r")

    #print("Just looping through keywords")
    keywordMap = dict()

    #populate a map for kewords to store the line numbers if found
    for i in range(len(sys.argv)-2):
        keyword = sys.argv[i+2]
        keywordMap[keyword] = ""



    line_number =0
    for line in f:
        line_number = line_number+1
        for word in line.split():
            #remove special charectores from begining and end
            mystring = re.sub("^\W+", "", word)
            mystring = re.sub("\W+$", "", mystring)
            if(keywordMap.__contains__(mystring)):
                keywordMap[mystring] = str(keywordMap[mystring]) + " "+str(line_number)
            
    absentList = list()
    print("keyword \t"+"line numbers")
    for k in keywordMap.keys():
        if(keywordMap[k] == ""):
            absentList.append(k)
        else:
            print(k +" \t"+keywordMap[k])
    
    print("keywords not found")
    for word in absentList:
        print(word)

    #source_code = nltk.word_tokenize(f.read())


main()