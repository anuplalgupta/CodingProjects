import openai
import os
import sys

def get_chatGpt_response(query):
    response = openai.Completion.create(
        engine="davinci",
        prompt=query,
        max_tokens=1024,
        n=1,
        stop=None,
        temperature=0.7,
    )

    return response.choices[0].text.strip()

name = sys.argv[1] #'Anup Lal Gupta'
curent_desig = sys.argv[2] #'Software engineer'
experience = sys.argv[3] #'9 years'
url = sys.argv[4] #'https://www.uber.com/global/en/careers/list/120371/'
openai.api_key = sys.argv[5] 
query = f'I am {name}, a {curent_desig} with {experience} years of experience. Create my cover letter for role posted here: {url} '
print(query)
res = get_chatGpt_response(query)
print(res)