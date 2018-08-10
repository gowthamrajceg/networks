
#Create a simulator object
set ns [new Simulator]


#Open the NAM trace file

set nf [open o.nam w]
$ns namtrace-all $nf

# create nodes

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n7 [$ns node]
set n8 [$ns node]
set n10 [$ns node]


#Create links between the nodes

$ns duplex-link $n0 $n2 2Mb 10ms DropTail
$ns duplex-link $n1 $n2 2Mb 10ms RED
$ns duplex-link $n2 $n3 1.7Mb 20ms RED
$ns duplex-link $n4 $n5 2Mb 10ms RED
$ns duplex-link $n2 $n8 2Mb 10ms RED
$ns duplex-link $n4 $n10 2Mb 5ms DropTail

#Define a 'finish' procedure

proc finish {} {
        global ns nf
        $ns flush-trace
        #Close the NAM trace file
        close $nf
        #Execute NAM on the trace file
        exec nam o.nam &
        exit 0
}



#Call the finish procedure

$ns at 1.0 "finish"

#Run the simulation

$ns run
