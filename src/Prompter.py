from openai import OpenAI

class ChatGPTClient:
    def __init__(self) -> None:
        self.client = OpenAI(
            # defaults to os.environ.get("OPENAI_API_KEY")
            api_key = "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"
        )

    def chat_with_gpt(self, prompt):
        try:
            response = self.client.chat.completions.create(
                model="gpt-4", 
                messages=[{"role": "user", "content": prompt}]
            )
            return response.choices[0].message.content
        except Exception as e:
            return f"An error occurred: {e}"

import PyPDF2

def extract_text_from_pdf(pdf_path):
    with open(pdf_path, 'rb') as file:
        reader = PyPDF2.PdfReader(file)
        text = ""
        for page in reader.pages:
            text += page.extract_text()
    return text

# Extract text from a PDF
pdf_text = extract_text_from_pdf("Wuhan/main.pdf")

def split_text_into_chunks(text, max_length=10000):
    return [text[i:i+max_length] for i in range(0, len(text), max_length)]

chunks = split_text_into_chunks(pdf_text)

# Query each chunk
client = ChatGPTClient()
for chunk in chunks:
    response = client.chat_with_gpt("Analyze this text: " + chunk)

response = client.chat_with_gpt("Given this list of parameters, knowing that all the papers and parameters are entites, each reference marks a derviation and agents are authors of each work, use the java api to create the provenance information of this work: Basic Reproduction Number (R0): 2.3 (Reference 6) | Time in Quarantine (days): 14 (Current policy) | Relative Risk of Transmission for Isolated Cases: 0.1 (Assumption) | Hospital Stay (Non-ICU) Duration (days): 10 (Reference 21) | ICU Stay Duration (days): 21 (Reference 22) | Hospital Stay Post-ICU (days): 21 (Reference 22)")
print("ChatGPT:", response)


# Manual: Give pdf: Ask for list of parameters and corresponding references
# Manual: Give link to EMODL specification: Ask for the .emodl file
# Script: Given this list of parameters, knowing that all the papers and 
# parameters are entites, each reference marks a derviation and agents are 
# authors of each work, use the java api to create the provenance information
# of this work 
# for each of the parameters:
# Manual: Given cited pdf: For parameter X with value Y what are the references cited 
# in this paper that suggests where it is coming from: include datasets, other studies or
# hypothesis that could be driving this assignment of values from the cited paper
# For each of the cited research works, repeat previous step
