package ch7

import (
	"flag"
	"fmt"
)

type Celsius float64
type Fahrenheit float64

func CToF(c Celsius) Fahrenheit {
	return Fahrenheit(c*9.0/5.0 + 32.0)
}

func FToC(f Fahrenheit) Celsius {
	return Celsius((f - 32.0) * 5.0 / 9.0)
}

func (c Celsius) String() string {
	return fmt.Sprintf("%g°C", c)
}

type celsiusValue Celsius

func (c *celsiusValue) String() string {
	return fmt.Sprintf("%.2f°C", *c)
}

func (c *celsiusValue) Set(s string) error {
	var unit string
	var value float64
	_, _ = fmt.Sscanf(s, "%f%s", &value, &unit)
	switch unit {
	case "C", "°C":
		*c = celsiusValue(value)
		return nil
	case "F", "°F":
		*c = celsiusValue(FToC(Fahrenheit(value)))
		return nil
	}
	return fmt.Errorf("invalid temperature %q", s)
}

func CelsiusFlag(name string, value Celsius, usage string) *Celsius {
	p := new(Celsius)
	*p = value
	flag.CommandLine.Var((*celsiusValue)(p), name, usage)
	return p
}

func TempConvRun() {
	temp := CelsiusFlag("temp", 36.7, "温度")

	flag.Parse()
	fmt.Printf("%T, %[1]v\n", temp)
}