import os
from PIL import Image, ImageTk
import tkinter as tk


class ImageComparator:
    def __init__(self, dir1, dir2):
        self.files1 = sorted(os.listdir(dir1))
        self.files2 = sorted(os.listdir(dir2))
        self.index = 0

        self.root = tk.Tk()
        self.root.title("Image Comparison")
        self.root.geometry("1150x500")  # Adjust the window size as needed

        self.frame1 = tk.Frame(self.root)
        self.frame1.grid(row=0, column=0, padx=10, pady=10)

        self.label_info1 = tk.Label(self.frame1, text="Before detection")
        self.label_info1.grid(row=0, column=0)
        self.label_info2 = tk.Label(self.frame1, text="After detection")
        self.label_info2.grid(row=0, column=1)

        self.image1_path1 = os.path.join(dir1, self.files1[self.index])
        self.image2_path1 = os.path.join(dir2, self.files2[self.index])

        self.image1_1 = Image.open(self.image1_path1)
        self.image2_1 = Image.open(self.image2_path1)

        self.image1_1 = self.image1_1.resize((540, 360))
        self.image2_1 = self.image2_1.resize((540, 360))

        self.photo1_1 = ImageTk.PhotoImage(self.image1_1)
        self.photo2_1 = ImageTk.PhotoImage(self.image2_1)

        self.label1_1 = tk.Label(self.frame1, image=self.photo1_1)
        self.label1_1.grid(row=1, column=0, padx=10, pady=5)

        self.label2_1 = tk.Label(self.frame1, image=self.photo2_1)
        self.label2_1.grid(row=1, column=1, padx=10, pady=5)

        self.button_next = tk.Button(self.frame1, text="Next", command=self.next_images)
        self.button_next.grid(row=2, column=0, padx=10, pady=5)
        self.button_previous = tk.Button(self.frame1, text="previous", command=self.previous_images)
        self.button_previous.grid(row=2, column=1, padx=10, pady=5)

    def next_images(self):

        if self.index >= len(self.files1) or self.index >= len(self.files2):
            return
        self.index += 1

        self.image1_path1 = os.path.join(dir1, self.files1[self.index])
        self.image2_path1 = os.path.join(dir2, self.files2[self.index])

        self.image1_1 = Image.open(self.image1_path1)
        self.image2_1 = Image.open(self.image2_path1)

        self.image1_1 = self.image1_1.resize((540, 360))
        self.image2_1 = self.image2_1.resize((540, 360))

        self.photo1_1 = ImageTk.PhotoImage(self.image1_1)
        self.photo2_1 = ImageTk.PhotoImage(self.image2_1)

        self.label1_1.configure(image=self.photo1_1)
        self.label2_1.configure(image=self.photo2_1)

    def previous_images(self):


        if self.index <= 0:
            return

        self.index -= 1

        self.image1_path1 = os.path.join(dir1, self.files1[self.index])
        self.image2_path1 = os.path.join(dir2, self.files2[self.index])

        self.image1_1 = Image.open(self.image1_path1)
        self.image2_1 = Image.open(self.image2_path1)

        self.image1_1 = self.image1_1.resize((540, 360))
        self.image2_1 = self.image2_1.resize((540, 360))

        self.photo1_1 = ImageTk.PhotoImage(self.image1_1)
        self.photo2_1 = ImageTk.PhotoImage(self.image2_1)

        self.label1_1.configure(image=self.photo1_1)
        self.label2_1.configure(image=self.photo2_1)

    def run(self):
        self.root.mainloop()


# Example usage
dir1 = "datasets/data/train/images"
dir2 = "runs/detect/predict"

app = ImageComparator(dir1, dir2)
app.run()
