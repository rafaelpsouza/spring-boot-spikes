Vagrant.configure(2) do |config|
	config.vm.synced_folder ".", "/vagrant", disabled: true

	config.vm.define "loadbalancer" do |loadbalancer|
		loadbalancer.vm.box = "ubuntu/trusty64"
		loadbalancer.vm.network "private_network", ip: "192.168.80.3"
		loadbalancer.vm.provision "ansible" do |ansible|
    		ansible.playbook = "haproxy.yml"
 		end
	end

	config.vm.define "services1" do |services1|
		services1.vm.box = "ubuntu/trusty64"
		services1.vm.network "private_network", ip: "192.168.80.4"
		services1.vm.provision "ansible" do |ansible|
    		ansible.playbook = "service.yml"
 		end
	end

	config.vm.define "services2" do |services2|
		services2.vm.box = "ubuntu/trusty64"
		services2.vm.network "private_network", ip: "192.168.80.5"
		services2.vm.provision "ansible" do |ansible|
    		ansible.playbook = "service.yml"
 		end
	end

end
