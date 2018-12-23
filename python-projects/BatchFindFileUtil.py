import sys
#import nltk
#nltk.download('punkt')
#An utility program to search a file for list of keywords and report presence 
# with line number


def main():
    if len(sys.argv) <  2:
        print("Usage: BatchFileFindUtil.py <file_absolute_path> <Keyword1> <Keyword2> ...")

    filePath = sys.argv[1]
    #print("file path is" + filePath)

    f = open(filePath,"r")

    #print("Just looping through keywords")
    keywordMap = dict()

    
    for i in range(len(sys.argv)-2):
        keyword = sys.argv[i+2]
        keywordMap[keyword] = ""
        print(keyword)



    l =0
    for line in f:
        l = l+1
        for word in line.split():
            if(keywordMap.__contains__(word)):
                keywordMap[word] = str(keywordMap[word]) + str(l)
            
    absentList = list()
    print("keyword \t"+"line numbers")
    for k in keywordMap.keys():
        if(keywordMap[k] == ""):
            absentList.append(k)
        else:
            print(k +"\t"+keywordMap[k])
    
    print("keywords not found")
    for word in absentList
        print(word)

    #source_code = nltk.word_tokenize(f.read())


main()