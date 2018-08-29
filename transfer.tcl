#——-Event scheduler object creation——–#
set ns [new Simulator]

#———-creating trace objects—————-#

set nt [open test2.tr w]
$ns trace-all $nt
#———-creating nam objects—————-#

set nf [open test2.nam w]
$ns namtrace-all $nf
#———-Setting color ID—————-#
$ns color 1 darkmagenta
$ns color 2 yellow
$ns color 3 blue
$ns color 4 green
$ns color 5 black

#———- Creating Network—————-#

set totalNodes 3

for {set i 0} {$i < $totalNodes} {incr i} {
set node_($i) [$ns node]
}

set server 0
set router 1
set client 2

#———- Creating Duplex Link—————-#
$ns duplex-link $node_($server) $node_($router) 2Mb 50ms DropTail
$ns duplex-link $node_($router) $node_($client) 2Mb 50ms DropTail

$ns duplex-link-op $node_($server) $node_($router) orient right
$ns duplex-link-op $node_($router) $node_($client) orient right

#————Labelling—————-#

$ns at 0.0 "$node_($server) label Server"
$ns at 0.0 "$node_($router) label Router"
$ns at 0.0 "$node_($client) label Client"

$ns at 0.0 "$node_($server) color blue"
$ns at 0.0 "$node_($client) color blue"

$node_($server) shape hexagon
$node_($client) shape hexagon
#————Data Transfer between Nodes—————-#

# Defining a transport agent for sending
set tcp [new Agent/TCP]

# Attaching transport agent to sender node
$ns attach-agent $node_($server) $tcp

# Defining a transport agent for receiving
set sink [new Agent/TCPSink]

# Attaching transport agent to receiver node
$ns attach-agent $node_($client) $sink

#Connecting sending and receiving transport agents
$ns connect $tcp $sink

#Defining Application instance
set ftp [new Application/FTP]

# Attaching transport agent to application agent
$ftp attach-agent $tcp

# Setting flow color
$tcp set fid_ 4

# data packet generation starting time
$ns at 1.0 "$ftp start"

# data packet generation ending time
$ns at 6.0 "$ftp stop"

#———finish procedure——–#

proc finish {} {
global ns nf nt
$ns flush-trace
close $nf
close $nt
puts "running nam…"
exec nam test2.nam &
exit 0
}

#Calling finish procedure
$ns at 10.0 "finish"
$ns run
