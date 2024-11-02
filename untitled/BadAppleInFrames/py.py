import os
import re

# Function to rename files
def rename_files_in_directory(directory):
    # Regex pattern to match "Frame-000000.png"
    pattern = re.compile(r'\[(\d+)\]\.png')

    # Loop through all files in the specified directory
    for filename in os.listdir(directory):
        match = pattern.match(filename)
        if match:
            # Extract the number and convert it to an integer to remove leading zeros
            number = int(match.group(1))
            new_filename = f'{number}.png'
            
            # Create the full path for the old and new filenames
            old_file = os.path.join(directory, filename)
            new_file = os.path.join(directory, new_filename)
            
            # Rename the file
            os.rename(old_file, new_file)
            print(f'Renamed: {old_file} to {new_file}')

# Specify the directory containing the files
directory_path = './'  # Change this to your directory path

# Call the function to rename files
rename_files_in_directory(directory_path)
