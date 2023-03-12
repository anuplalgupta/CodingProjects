# Create a cover letter for any Job openning 

## How to use
- Clone/Download this code and open a terminal/power shell 
- cd python-projects\ChatGPT\CoverLetterGenerator
- run following 
```
python3 .\GenerateCoverLetter.py '<Name>' '<Current Designation>' '<years of experience>' '<Web url of role posting>' '<API-Key-OpenAI>'
```
### Options 
- Name : Your professional name that you want you use in the cover letter and application
- Current Designation : Your role with most years of experience, it helps the ChatGPT to personalize the cover letter for you. We might add more options in future to make the output more custom to role and individual.
- Experience : in years
- Web url: HTTP link to the public job posting. Warning: The URL should be publicly accessible and shouldn't be redirect/shortened (e.g bitly or tinyurl). This seems to be limitation from OpenAI API 
- OpenAI-API-Key : Sign up to open API and visit https://platform.openai.com/account/api-keys to create and get the key. You might need to upgrade and add your card in order to use this API else you will be getting "Limit exceeded" error. But don't worry they give you 5$ credit and thats enough to generate 100s of cover letter. Unless you exhaust that you won't be charged. I know its seems like bit of hassle but its one time thing, might be worth trying. [More details](https://platform.openai.com/docs/api-reference/introduction)


## Example:
```
python3 .\GenerateCoverLetter.py 'Anup lal Gupta' 'Software Engineer' '9' 'https://www.uber.com/global/en/careers/list/120371/' '<openai-api-key>'
```
### Sample output
```
Dear Hiring Manager,

I am excited to submit my application for the Software Engineer role posted on the Uber careers page. With 9 years of experience in software development and a passion for innovation, I believe that I have the skills and knowledge necessary to make a valuable contribution to your team.

Throughout my career, I have demonstrated an ability to develop high-quality software solutions that meet the needs of customers and business stakeholders. I have experience working with a wide range of programming languages, including Java, Python, and C++, and I am comfortable working with both front-end and back-end technologies. Additionally, I have experience working in Agile development environments and have a strong understanding of best practices in software engineering.

As a software engineer, I am always looking for new and innovative ways to solve problems and improve software applications. I am a self-starter who is comfortable working independently or as part of a team, and I am committed to delivering high-quality work on time and on budget. I am excited about the opportunity to bring my skills and experience to Uber and help drive the company's mission forward.

Thank you for considering my application. I look forward to the opportunity to discuss my qualifications further.

Sincerely,
Anup Lal Gupta
```

## Upcoming feature
- Run it as web service for the ease of use and every user won't need their own openai api key.
- Automate to generate multiple cover letter for a collection of roles (One cover letter for each url provide as list)