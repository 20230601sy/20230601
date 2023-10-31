import PIL
from PIL import Image
from PIL import ImageGrab

pix = ImageGrab.grab().load()
image = ImageGrab.grab()
image.size
image.show()


In [69]: with Image.open("csweeper.png") as im:
    ...:     print(im.getbbox())
    ...:     pix = im.load()
    ...:     x0 = 13
    ...:     dx = 16
    ...:     y0 = 95
    ...:     dy = 16
    ...:     for i in range(57):
    ...:         for y in range (y0, y0+dy):
    ...:             for x in range (x0, x0+dy):
    ...:                 pix[x, y]=0
    ...:         x0 += dx
    ...:         y0 += dy
    ...:     im.show()

(0, 1, 1274, 1019)


In [67]: with Image.open("csweeper.png") as im:
    ...:     pix = im.load()
    ...:     x0 = 13
    ...:     dx = 16
    ...:     y0 = 95
    ...:     dy = 16
    ...:     a = [0]*57
    ...:     for i in range(57):
    ...:         a[i] = pix[x0+8, y0+8]
    ...:         if(a[i]==0):
    ...:             b[i]=-1
    ...:         if(a[i]==139):
    ...:             b[i]=2
    ...:         if(a[i]==140):
    ...:             b[i]=1
    ...:         if(a[i]==133):
    ...:             b[i]=3
    ...:         x0 += dx
    ...:         y0 += dy
    ...:     im.show()
    ...:     print(a)
    ...:     print(b)




In [26]: with Image.open("csweeper.png") as im:
    ...:     pix = im.load()
    ...:     x0 = 13
    ...:     dx = 16
    ...:     y0 = 95
    ...:     dy = 16
    ...:     a = [[0]*16] *16
    ...:     for i in range(7):
    ...:         for y in range (y0, y0+dy):
    ...:             for x in range (x0, x0+dy):
    ...:                 a[y-y0][x-x0] = pix[x, y]
    ...:             print(a[y-y0])
    ...:         print("=============================")
    ...:         x0 += dx
    ...:         y0 += dy
