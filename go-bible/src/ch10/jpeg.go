package ch10

import (
	"fmt"
	"image"
	"image/jpeg"
	"io"
	"os"
)

func toJPEG(in io.Reader, out io.Writer) error {
	img, kind, err := image.Decode(in)
	if err != nil {
		return err
	}
	fmt.Fprintln(os.Stderr, "Input format = ", kind)
	return jpeg.Encode(out, img, &jpeg.Options{Quality: 95})
}

func JPEGRun() {
	fmt.Printf("%v\n", *os.Stdin)
	fmt.Printf("%v\n", *os.Stdout)
	//if err := toJPEG(os.Stdin, os.Stdout); err != nil {
	//	fmt.Fprintf(os.Stderr, "jpeg: %v\n", err)
	//}
}